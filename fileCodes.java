    public void readFile() {
        //Read Users list file first
        /*
        * How is file formatted?
        *
        * Customer,email,name,password
        * pastPurchaseitem1,quantity
        * pastPurchaseitem2,quantity
        * ...
        * --------
        * shoppingcartitem1, storename
        * shoppingcartitem2, storename
        * shoppingcartitem3, storename
        * ...
        * --------
        * Seller, email, name, password
        * -------- <<this must always come after each user desc
        * ...
        *
        * Line change will be made with eight dashes
        * breaking point will be nextLine() == null
        * must have -------- at the end
        * */
        File users = new File("UsersList.txt");
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Seller> sellers = new ArrayList<>();
        ArrayList<String> customerTempCart = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(users);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (true) {
                String lineNext = bufferedReader.readLine();
                if (lineNext == null) {
                    break;
                }
                while (true) {
                    if (lineNext.equals("--------")) {
                        break;
                    }
                    String[] firstLine = lineNext.split(",");
                    if (firstLine[0].equals("Customer")) {
                        Customer customerCurrent = new Customer(firstLine[1], firstLine[2], firstLine[3]);
                        while (true) {
                            String productsList = bufferedReader.readLine();
                            if (productsList.equals("--------")) {
                                break;
                            }
                            String[] pastPurchase = productsList.split(",");
                            customerCurrent.addProducts(pastPurchase[0], Integer.parseInt(pastPurchase[1]));
                        }
                        Stringbuilder customerCartBuild = new Stringbuilder();
                        while (true) {
                            String shoppingList = bufferedReader.readLine();
                            if (shoppingList.equals("--------")) {
                                break;
                            }
                            customerCartBuild.append(shoppingList);
                            customerCartBuild.append("\n");
                        }
                        customerTempCart.add(customerCartBuild.toString());
                        customers.add(customerCurrent);
                    } else {
                        Seller sellerCurrent = new Seller(firstLine[1], firstLine[1], firstLine[2]);
                        sellers.add(sellerCurrent);
                        bufferedReader.readLine();
                    }

                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            System.out.println("Invalid file format!");
        }
        File storeList = new File("StoreList.txt");
        ArrayList<Store> stores = new ArrayList<>();
        ArrayList<Products> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(storeList);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //entire file
            while (true) {
                String lineNext = bufferedReader.readLine();
                if (lineNext == null) {
                    break;
                }
                Seller currentSeller = null;
                Store currentStore = null;
                //each store
                while (true) {
                    if (lineNext.equals("--------")) {
                        break;
                    }
                    String storeName = lineNext;
                    String[] sellerDesc = bufferedReader.readLine().split(",");
                    String sellerName = sellerDesc[0];
                    String sellerEmail = sellerDesc[1];
                    for (Seller seller : sellers) {
                        if (seller.getName().equals(sellerName) && seller.getEmail().equals(sellerEmail)) {
                            currentSeller = seller;
                            break;
                        }
                    }
                    currentStore = new Store(storeName, sellerName, sellerEmail);
                    currentStore.setRevenue(Double.parseDouble(bufferedReader.readLine()));
                    currentStore.setSales(Integer.parseInt(bufferedReader.readLine()));

                    //customerList
                    while (true) {
                        lineNext = bufferedReader.readLine();
                        if (lineNext.equals("--------")) {
                            break;
                        } else {
                            String[] customerDetails = lineNext.split(",");
                            for (Customer customerpotential : customers) {
                                if (customerpotential.getName().equals(customerDetails[0]) && customerpotential.getEmail().equals(customerDetails[1])) {
                                    ArrayList<Customer> customerList = currentStore.getCustomers();
                                    customerList.add(customerpotential);
                                    currentStore.setCustomers(customerList);
                                    break;
                                }
                            }
                        }
                    }

                    //productList
                    while (true) {
                        lineNext = bufferedReader.readLine();
                        if (lineNext.equals("--------")) {
                            break;
                        }
                        String[] productDetails = lineNext.split(",");
                        Products currentProduct = new Products(productDetails[0], Double.parseDouble(productDetails[1]), Integer.parseInt(productDetails[2]),
                                productDetails[3], Integer.parseInt(productDetails[4]), storeName);
                        currentStore.addGoods(currentProduct);
                        products.add(currentProduct);

                    }
                }
                stores.add(currentStore);
                currentSeller.addStore(currentStore);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            System.out.println("Invalid file format!");
        }
        
        for (int i = 0; i < customers.size(); i++) {
            Customer currentCustomer = customers.get(i);
            String[] customerCartContents = customerTempCart.get(i).split("\n");
            for (int j = 0; j < customerCartContents.length; j++) {
                boolean foundItem = false;
                String[] itemDesc = customerCartContents.get(j).split(",");
                String itemName = itemDesc[0];
                String storeName = itemDesc[1];
                for (Products productInQuestion : products) {
                    if (productInQuestion.getName().equals(itemName) && productInQuestion.getStoreName().equals(storeName)) {
                        currentCustomer.addToShoppingCart(productInQuestion);
                        foundItem = true;
                        break;
                    }
                }
                if (!found) {
                    currentCustomer.shoppingCartChangeHelper(itemName);
                }
            }
        }
    }

    public void writeFile() {
        File users = new File("UsersList.txt");
        try {
            FileWriter fileWriter = new FileWriter(users, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Customer customer : customers) {
                printWriter.println("Customer," + customer.getEmail() + "," +  customer.getName() + "," + customer.getPassword());
                for (int i = 0; i < customer.getPastPurchase().size(); i++) {
                    printWriter.println(customer.getPastPurchase().get(i) + "," + customer.getPurchaseCount().get(i));
                }
                printWriter.println("--------");
                for (int j = 0; j < customer.getShoppingCart.size(); j++) {
                    printWriter.println(customer.shoppingCart().get(i).getName() + "," + customer.shoppingCart().get(i).getStoreName());
                }
                printWriter.println("--------");
            }
            for (Seller seller : sellers) {
                printWriter.println("Seller," + seller.getEmail() + "," + seller.getName() + "," + seller.getPassword());
                printWriter.println("--------");
            }
        } catch (Exception e) {
            int i = 0;
        }

        File storeFile = new File("StoreList.txt");
        try {
           FileWriter fileWriter = new FileWriter(storeFile, false);
           PrintWriter printWriter = new PrintWriter(fileWriter);

           for (Store store : stores) {
               printWriter.println(store.getName());
               printWriter.println(store.getSellerName() + "," + store.getSellerEmail());
               printWriter.println(store.getRevenue());
               printWriter.println(store.getSales());
               for (Customer customer : store.getCustomers()) {
                   printWriter.println(customer.getName() + "," + customer.getEmail());
               }
               printWriter.println("--------");
               for (Products product : store.getGoods()) {
                   printWriter.println(product.getName() + "," + product.getPrice() + "," + product.getQuantity() +
                           "," + product.getDescription() + "," + product.getSales());
               }
               printWriter.println("--------");
           }
           printWriter.close();
        } catch (Exception e) {
            int i = 0;
        }
    }
