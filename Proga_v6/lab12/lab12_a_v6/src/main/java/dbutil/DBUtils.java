package dbutil;

import entity.Good;
import entity.Order;
import main.java.connector.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class DBUtils {
    private DBConnector dbConnector;
    private Connection connection;

    public DBUtils() {
        this.dbConnector = new DBConnector();
        this.connection = this.dbConnector.getConnection();
    }

    public ResultSet getQueryResultAsResultSet(String query) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void executeInsertOrUpdateOrDeleteQuery(String query) {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getTableLength(String table) {
        int length = 0;

        String lengthQuery = "SELECT * FROM " + table;
        ResultSet resultSet = this.getQueryResultAsResultSet(lengthQuery);

        try {
            while (resultSet.next()) {
                length++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return length;
    }

    // 1
    public Order getOrderById(int orderId) {
        try {
            String orderIdQuery = "SELECT * FROM ORD WHERE ID = " + orderId;
            ResultSet resultSet = this.getQueryResultAsResultSet(orderIdQuery);
            resultSet.next();

            return new Order(resultSet.getInt("ORDER_CODE"),
                    resultSet.getDate("SEND_DATE"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Integer> getGoodIdsByOrderId(int orderId) {
        ArrayList<Integer> goodIds = new ArrayList<Integer>();

        String goodIdsQuery = "SELECT GOOD_ID FROM ORD_LNK_GOOD WHERE ORDER_ID = " + orderId;
        ResultSet resultSet = this.getQueryResultAsResultSet(goodIdsQuery);

        try {
            while (resultSet.next()) {
                goodIds.add(resultSet.getInt("GOOD_ID"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return goodIds;
    }

    public ArrayList<Integer> getGoodAmountsByOrderId(int orderId) {
        ArrayList<Integer> goodAmounts = new ArrayList<Integer>();

        String goodIdsQuery = "SELECT GOOD_AMOUNT FROM ORD_LNK_GOOD WHERE ORDER_ID = " + orderId;
        ResultSet resultSet = this.getQueryResultAsResultSet(goodIdsQuery);

        try {
            while (resultSet.next()) {
                goodAmounts.add(resultSet.getInt("GOOD_AMOUNT"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return goodAmounts;
    }

    public String ArrayListToSQLList(ArrayList<Integer> integers) {
        StringBuilder sqlListBuilder = new StringBuilder().append("(");

        for(int i = 0; i < integers.size(); i++) {
            if (i == integers.size() - 1) {
                sqlListBuilder.append(integers.get(i));
            }
            else {
                sqlListBuilder.append(integers.get(i)).append(", ");
            }
        }

        return sqlListBuilder.append(")").toString();
    }

    public int getGoodsPriceByGoodIdsAndGoodAmounts(ArrayList<Integer> goodIds, ArrayList<Integer> goodAmounts) {
        int sumPrice = 0;

        String query = "SELECT PRICE FROM GOOD WHERE ID IN " + this.ArrayListToSQLList(goodIds);
        ResultSet resultSet = this.getQueryResultAsResultSet(query);

        try {
            int counter = 0;

            while (resultSet.next()) {
                sumPrice += resultSet.getInt("PRICE") * goodAmounts.get(counter);
                counter++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sumPrice;
    }

    public Good getGoodById(int goodId) {
        String goodQuery = "SELECT * FROM GOOD WHERE ID = " + goodId;
        ResultSet resultSet = this.getQueryResultAsResultSet(goodQuery);
        try {
            resultSet.next();

            return new Good(resultSet.getInt("CODE"),
                    resultSet.getString("NAME"),
                    resultSet.getString("DESCRIPTION"),
                    resultSet.getInt("PRICE"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Good getGoodByName(String name) {
        String goodQuery = "SELECT * FROM GOOD WHERE NAME = " + name;
        ResultSet resultSet = this.getQueryResultAsResultSet(goodQuery);
        try {
            resultSet.next();

            return new Good(resultSet.getInt("CODE"),
                    resultSet.getString("NAME"),
                    resultSet.getString("DESCRIPTION"),
                    resultSet.getInt("PRICE"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteOrderById(int orderId) {
        String deleteOrderQuery = "DELETE FROM ORD WHERE ID = " + orderId;
        this.executeInsertOrUpdateOrDeleteQuery(deleteOrderQuery);
    }

    public void deleteLNKRowsByOrderId(int orderId) {
        String deleteLNKRowsQuery = "DELETE FROM ORD_LNK_GOOD WHERE ORDER_ID = " + orderId;
        this.executeInsertOrUpdateOrDeleteQuery(deleteLNKRowsQuery);
    }

    public void insertNewLNK(int orderId, int goodId, int goodAmount) {
        int newLNKId = this.getTableLength("ORD_LNK_GOOD") + 1;

        String insertLNKQuery = new StringBuilder("INSERT INTO ORD_LNK_GOOD VALUES(")
                .append(newLNKId)
                .append(", ")
                .append(orderId)
                .append(", ")
                .append(goodId)
                .append(", ")
                .append(goodAmount)
                .append(")").toString();
        this.executeInsertOrUpdateOrDeleteQuery(insertLNKQuery);
    }

    public void duplicateLNKRowByOrderId(int orderId, int newOrderId) {
        String allLNKQuery = "SELECT * FROM ORD_LNK_GOOD";

        ResultSet resultSet = this.getQueryResultAsResultSet(allLNKQuery);
        try {
            while (resultSet.next()) {
                if(resultSet.getInt("ORDER_ID") == orderId) {
                    this.insertNewLNK(newOrderId,
                            resultSet.getInt("GOOD_ID"),
                            resultSet.getInt("GOOD_AMOUNT"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Good> getGoodsByGoodIdsArrayList(ArrayList<Integer> goodIds) {
        return goodIds.stream()
                .map(this::getGoodById)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int getOrderPriceById(int orderId) {
        ArrayList<Integer> goodIds = this.getGoodIdsByOrderId(orderId);
        ArrayList<Integer> goodAmounts = this.getGoodAmountsByOrderId(orderId);

        return this.getGoodsPriceByGoodIdsAndGoodAmounts(goodIds, goodAmounts);
    }

    public int getGoodTypesAmountByOrderId(int orderId) {
        int amount = 0;

        String query = "SELECT * FROM ORD_LNK_GOOD WHERE ORDER_ID = " + orderId;
        ResultSet resultSet = this.getQueryResultAsResultSet(query);

        try {
            while (resultSet.next()) {
                amount++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return amount;
    }

    // 2
    public ArrayList<Order> getOrdersByMaxPriceAndGoodTypesAmount(int maxPrice, int goodTypesAmount) {
        ArrayList<Order> filteredOrders = new ArrayList<Order>();

        String orderIdsQuery = "SELECT ID FROM ORD";
        ResultSet resultSet = this.getQueryResultAsResultSet(orderIdsQuery);

        try {
            while (resultSet.next()) {
                int orderId = resultSet.getInt("ID");

                if (this.getGoodTypesAmountByOrderId(orderId) == goodTypesAmount &&
                        this.getOrderPriceById(orderId) <= maxPrice) {
                    filteredOrders.add(this.getOrderById(orderId));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return filteredOrders;
    }

    public ArrayList<Good> getGoodsByOrderId(int orderId) {
        return this.getGoodsByGoodIdsArrayList(this.getGoodIdsByOrderId(orderId));
    }

    //3
    public ArrayList<Integer> getOrderCodesByGoodName(String name) {
        ArrayList<Integer> orderCodes = new ArrayList<Integer>();

        String allOrdersQuery = "SELECT * FROM ORD";
        ResultSet resultSet = this.getQueryResultAsResultSet(allOrdersQuery);

        try {
            while (resultSet.next()) {
                int orderId = resultSet.getInt("ID");
                int orderCode = resultSet.getInt("ORDER_CODE");

                ArrayList<Good> goods = this.getGoodsByOrderId(orderId);

                if (goods.stream().anyMatch(good -> good.getName().equals(name))) {
                    orderCodes.add(orderCode);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return orderCodes;
    }

    public boolean areSameDayDates(Date d1, Date d2) {
        return (d1.getYear() == d2.getYear()) &&
                (d1.getMonth() == d2.getMonth()) &&
                (d1.getDay() == d2.getDay());
    }

    //4
    public ArrayList<Integer> getSentTodayOrderCodesNotContainingGood(String name) {
        ArrayList<Integer> orderCodes = new ArrayList<Integer>();

        String allOrdersQuery = "SELECT * FROM ORD";
        ResultSet resultSet = this.getQueryResultAsResultSet(allOrdersQuery);

        try {
            while (resultSet.next()) {
                int orderId = resultSet.getInt("ID");
                int orderCode = resultSet.getInt("ORDER_CODE");
                Date orderDate = resultSet.getDate("SEND_DATE");
                Date todayDate = new Date();

                ArrayList<Good> goods = this.getGoodsByOrderId(orderId);

                if (goods.stream().noneMatch(good -> good.getName().equals(name)) &&
                        this.areSameDayDates(orderDate, todayDate)) {
                    orderCodes.add(orderCode);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return orderCodes;
    }

    public int getLastOrderCode() {
        int lastCode = -1;
        String lastCodeQuery = "SELECT ORDER_CODE FROM ORD WHERE ID = " + this.getTableLength("ORD");

        ResultSet resultSet = this.getQueryResultAsResultSet(lastCodeQuery);
        try {
            resultSet.next();
            lastCode = resultSet.getInt("ORDER_CODE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lastCode;
    }

    //5
    public void sendOrderConsistingOfTodayGoods() {
        String allOrdersQuery = "SELECT * FROM ORD";
        ResultSet initialResultSet = this.getQueryResultAsResultSet(allOrdersQuery);

        int newOrderId = this.getTableLength("ORD") + 1;
        int newOrderCode = this.getLastOrderCode() + 1;
        String insertNewOrderQuery = new StringBuilder("INSERT INTO ORD VALUES (")
                .append(newOrderId)
                .append(", ")
                .append(newOrderCode)
                .append(", '")
                .append((new Order()).getSQLDate())
                .append("')").toString();

        this.executeInsertOrUpdateOrDeleteQuery(insertNewOrderQuery);

        try {
            while (initialResultSet.next()) {
                int orderId = initialResultSet.getInt("ID");
                Date orderDate = initialResultSet.getDate("SEND_DATE");
                Date todayDate = new Date();

                if (this.areSameDayDates(orderDate, todayDate)) {
                    this.duplicateLNKRowByOrderId(orderId, newOrderId);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //6
    public void deleteOrdersWithGoodAndItsAmount(String name, int amount) {
        String allOrdersQuery = "SELECT * FROM ORD";
        ResultSet resultSet = this.getQueryResultAsResultSet(allOrdersQuery);

        try {
            while (resultSet.next()) {
                int orderId = resultSet.getInt("ID");

                ArrayList<String> goodsNames = this.getGoodsByOrderId(orderId).stream()
                        .map(Good::getName)
                        .collect(Collectors.toCollection(ArrayList::new));
                ArrayList<Integer> goodAmounts = this.getGoodAmountsByOrderId(orderId);

                for (int i = 0; i < goodAmounts.size(); i++) {
                    if (goodsNames.get(i).equals(name) && goodAmounts.get(i) == amount) {
                        this.deleteLNKRowsByOrderId(orderId);
                        this.deleteOrderById(orderId);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
