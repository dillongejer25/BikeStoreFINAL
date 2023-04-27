package IstTeam5;
/**
 * @author Parth Patel
 */

/**Property for Store Class
 *
 */
public class Store {


    public int getStoreId() {

        return storeId;

    }

    public void setStoreId(int iStore){

        storeId = iStore;

    }

    public void setStoreName(String sname){

        storename = sname;

    }

    public void StoreId(int storeId) {

        this.storeId = storeId;

    }

    public String getStorename() {

        return storename;

    }

    public void setStorename(String storename) {

        this.storename = storename;
    }
    public String Str(){
        return storename;
    }
    private int storeId;

    private String storename; //class level variable


    public Store(int sId){

        storeId = sId;

    }
    public Store(String storename) {

        this.storename = storename;

    }

    public Store(int sId, String sname){

        storeId = sId;

        storename = sname;

    }

}