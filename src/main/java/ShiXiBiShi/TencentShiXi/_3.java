package main.java.ShiXiBiShi.TencentShiXi;

import java.util.*;

/**
 * Created by Rinchar on 2018/4/5.
 */

public class _3 {
    static class PACK{
        int w; //time
        int z; //rank

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }
    }
    static class Task{
        int w; //time
        int z; //rank

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int m = in.nextInt();

        List<PACK> packs = new ArrayList<PACK>();
        for(int i=0;i<n;i++){
            PACK pack = new PACK();
            pack.setW(in.nextInt());
            pack.setZ(in.nextInt());
            packs.add(pack);
        }

        List<Task> tasks = new ArrayList<Task>();
        for(int i=0;i<m;i++){
            Task task = new Task();
            task.setW(in.nextInt());
            task.setZ(in.nextInt());
            tasks.add(task);
        }

        Collections.sort(packs, new Comparator<PACK>() {
            public int compare(PACK o1, PACK o2) {
                if(o1.getZ()>=o2.getZ()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        Collections.sort(tasks, new Comparator<Task>() {
            public int compare(Task o1, Task o2) {
                if(o1.getW()>=o2.getW()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        List<Integer> tempList = new ArrayList<Integer>();
        List<Integer> tempi = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int max1 =0;
            int temp1=-1;
            int temp2=-1;
            for(int j=0;j<m;j++){
                if(!tempList.contains(j)){
                    if(packs.get(i).getZ()>=tasks.get(j).getZ()){
                        int value = 200*tasks.get(j).getW()+3*tasks.get(j).getZ();
                        if(max1<value){
                            temp1=j;
                            //temp2=i;
                            max1 = value;
                            System.out.println(max1);
                        }
                    }
                }
            }
            if(temp1>0){
                tempList.add(temp1);
                tempi.add(temp1);
            }

        }
        System.out.println(tempi.size());
        int sum=0;
        for(int i=0;i<tempi.size();i++){
            sum+=200*tasks.get(tempi.get(i)).getW()+3*tasks.get(tempi.get(i)).getZ();
        }
        System.out.println(sum);

    }

}
