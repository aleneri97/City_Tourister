package com.example.alejandro_neri.city_tourister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> passengers = new ArrayList<String>();

        for (int i = 0; i < CustomAdapter.editModelArrayList.size(); i++){
            passengers.add(CustomAdapter.editModelArrayList.get(i).getEditTextValue() +System.getProperty("line.separator"));
        }


        expandableListDetail.put(passengers.size()+" Pasajeros", passengers);

        return expandableListDetail;
    }
}
