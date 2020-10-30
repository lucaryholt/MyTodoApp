package com.lucaryholt.mytodoapp.Repo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.lucaryholt.mytodoapp.Interface.Toastable;
import com.lucaryholt.mytodoapp.Interface.Updateable;
import com.lucaryholt.mytodoapp.Model.ToDoItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repo {

    private Updateable activity;
    private Toastable toastable;
    private final ArrayList<ToDoItem> items = new ArrayList<>();
    private static final Repo instance = new Repo();

    private final FirebaseStorage storage = FirebaseStorage.getInstance();

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference col = db.collection("items");

    private final String ID = "id";
    private final String TITLE = "title";
    private final String TEXT = "text";
    private final String IMAGENAME = "imageName";
    private final String DONE = "done";

    public void setActivity(Updateable a){
        activity = a;
        startListener();
    }

    public void setToastable(Toastable toastable) {
        this.toastable = toastable;
    }

    public static Repo r(){
        return instance;
    }

    public ArrayList<ToDoItem> getItems(){
        return items;
    }

    public void addItem(ToDoItem item){
        DocumentReference ref = col.document(item.getId());
        Map<String, String> map = new HashMap<>();
        map.put(TITLE, item.getTitle());
        map.put(TEXT, item.getText());
        map.put(IMAGENAME, item.getImageName());
        map.put(DONE, item.isDone() + "");

        ref.set(map).addOnCompleteListener(task -> {
            if(!task.isSuccessful()){
                System.out.println("Could not save item.");
            }
        });

        toastable.showToast("Item " + item.getTitle() + " is added");
    }

    public ToDoItem getItem(int index){
        return items.get(index);
    }

    public ToDoItem getItem(long index){
        int i = (int) index;
        return getItem(i);
    }

    public void deleteItem(String id){
        col.document(id).delete();
        activity.update(null);

        toastable.showToast("Item deleted");
    }

    public void updateItem(String id, String title, String text, boolean done){
        DocumentReference ref = col.document(id);
        Map<String, String> map = new HashMap<>();
        map.put(TITLE, title);
        map.put(TEXT, text);
        map.put(IMAGENAME, ""); //TODO
        map.put(DONE, done + "");

        ref.set(map);
    }

    public void startListener(){
        col.addSnapshotListener((values, error) -> {
            items.clear();
            assert values != null;
            for(DocumentSnapshot snap : values.getDocuments()){
                items.add(new ToDoItem(snap.getId(), (String) snap.get(TITLE), (String) snap.get(TEXT), (String) snap.get(IMAGENAME), Boolean.parseBoolean((String) snap.get(DONE))));
            }
            if(activity != null){
                activity.update(null);
            }
        });
    }

    public void downloadBitmap(String fileName, Updateable updateable){
        StorageReference ref = storage.getReference(fileName);
        int max = 1024*1024;
        ref.getBytes(max).addOnSuccessListener(bytes -> {
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            updateable.update(bitmap);
        }).addOnFailureListener(ex -> {
            System.out.println("error in download " + ex);
        });
    }

}
