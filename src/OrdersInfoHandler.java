import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrdersInfoHandler {
    static boolean checkIfContainsUUID(String orderInfo) {
        Pattern catcher = Pattern.compile("orderUUID");
        Matcher matcher = catcher.matcher(orderInfo);

        return matcher.find();
    }

    static String findOrderUUID(String orderInfo) {
        Pattern catcher = Pattern.compile("(?<=(orderUUID=))([^ ]+)");
        Matcher matcher = catcher.matcher(orderInfo);

        if (matcher.find()) {
            return matcher.group();
        }
        else {
            return null;
        }
    }

    static String findEmail(String mailData) {
        Pattern catcher = Pattern.compile("([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)");
        Matcher matcher = catcher.matcher(mailData);

        if (matcher.find()) {
            return matcher.group();
        }
        else {
            return null;
        }
    }

    static String checkHowManyOrders(String orderData) {
        Pattern catcher = Pattern.compile("orders successfully processed: \\[([0-9]*)\\]");
        Matcher matcher = catcher.matcher(orderData);

        if (matcher.find()) {
            return matcher.group(1);
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        final String ORDER_1 = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - " +
                "action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 " +
                "orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";

        final String MAIL = "test 2667843 (test_email@griddynamics.com) test 67483 some string";

        final String ORDER_2 = "app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract" +
                " INFO  LogUtils - POI file name: [Integration_test_Contract], " +
                "total number of orders successfully processed: [2]";

        System.out.println(checkIfContainsUUID(ORDER_1));
        System.out.println(findOrderUUID(ORDER_1));
        System.out.println(findEmail(MAIL));
        System.out.println(checkHowManyOrders(ORDER_2));
    }
}