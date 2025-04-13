package db;

import model.Item;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;

    private List <Item> itemList;

    private DBConnection(){
        itemList = new ArrayList<>();
    }
    public List<Item> getDBList(){
        return itemList;
    }
    public static DBConnection getInstance(){
        return instance==null?instance=new DBConnection():instance;
    }
}
