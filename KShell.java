package cn.nuist.network;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KShell {
    public static void main(String[] args) {
        String path = "/Users/cjz/data/email.txt";
        ArrayList<Integer[]> mylist = readFile(path);
//        for(int i = 0; i < mylist.size(); i ++){
//            System.out.println(mylist.get(i)[0] + "," + mylist.get(i)[1]);
//        }
        HashMap<Integer, HashSet<Integer>>
                mymap = get_netnetwork(mylist);

        show_neighbors(mymap, 43);
    }

    private static void show_neighbors(HashMap<Integer, HashSet<Integer>>
                                               mymap, int id){
        HashSet<Integer> myset = mymap.get(id);
        Iterator<Integer> it = myset.iterator();
        Integer node_id = 0;
        while(it.hasNext()){
            node_id = it.next();
            System.out.print(node_id + ",");
        }
        System.out.println();


    }

    private static HashMap<Integer, HashSet<Integer>>
    get_netnetwork(ArrayList<Integer[]> mylist){
        HashMap<Integer, HashSet<Integer>> mymap
                = new HashMap<Integer, HashSet<Integer>>();
        Integer num1 = 0;
        Integer num2 = 0;
        HashSet<Integer> tmpset = null;
        for(int i = 0; i < mylist.size(); i ++){
            num1 = mylist.get(i)[0];
            num2 = mylist.get(i)[1];
            build_map_record(mymap, num1, num2);
            build_map_record(mymap, num2, num1);
        }
        return mymap;
    }

    private static void build_map_record(HashMap<Integer, HashSet<Integer>> mymap, Integer num1, Integer num2) {
        HashSet<Integer> tmpset;
        if(!mymap.containsKey(num1)){
            tmpset = new HashSet<Integer>();
            tmpset.add(num2);
            mymap.put(num1, tmpset);
        }else{
            mymap.get(num1).add(num2);
        }
    }

    private static ArrayList<Integer[]> readFile(String path){
        ArrayList<Integer[]> mylist = new ArrayList<Integer[]>();
        String str = null;
        String[] str_array = null;
        Integer[] int_array = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            while ((str = in.readLine()) != null) {
                str_array = str.split(",");
                int_array = string_array2int_array(str_array);
                mylist.add(int_array);
                //System.out.println(int_array[0] + "," + int_array[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mylist;
    }

    /**
     *
     * @param str_array: string array
     * @return int array
     */
    private static Integer[] string_array2int_array(String[] str_array){
        Integer[] int_array = null;
        int num1 = Integer.parseInt(str_array[0]);
        int num2 = Integer.parseInt(str_array[1]);
        int_array = new Integer[]{num1, num2};
        return int_array;
    }
}
