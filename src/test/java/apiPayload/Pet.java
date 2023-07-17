package apiPayload;

import org.codehaus.groovy.util.ListHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pet {

    int id;

    HashMap<String,String> category = new HashMap<>();

    public HashMap<String, String> getCategory() {
        return category;
    }

    public void setCategory(HashMap<String, String> category) {
        this.category = category;
    }

    String name;
   String photoUrls[];

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    List<HashMap<String,String>> tags = new ArrayList<>();
    public List<HashMap<String, String>> getTags() {
        return tags;
    }

    public void setTags(HashMap<String, String> tags) {

        this.tags.add(tags);
    }


    String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
