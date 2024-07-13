class Solution {

    class Data{
        int pos, hel, index;
        char  dir;
        Data(int pos, int hel, char dir, int index){
            this.index=index;
            this.pos=pos;
            this.hel=hel;
            this.dir=dir;
        }

        public String toString(){
            return "["+pos+" "+hel+" "+dir+"]";
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {


        int n=positions.length;
        Data data[]=new Data[n];

        for(int i=0;i<n;i++){
            data[i]=new Data(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(data, (i, j)->i.pos-j.pos);
        
        return h(data);

        
    }

    public List<Integer> h(Data []data){
        Stack<Data>st=new Stack<>();
        List<Data>sortList=new ArrayList<>();
        for(Data d:data){
            if(!st.isEmpty() &&  d.dir=='R' && d.pos==st.peek().pos){

                    Data pop=st.pop();
                    Data max=getMax(pop, d);
                    max.hel--;
                    st.push(max);
                    continue;
            }
            if(d.dir=='R'){
                st.push(d);
            }
            else{
                if(st.isEmpty()){
                    sortList.add(d);
                }
                while(!st.isEmpty() && d.dir=='L'){
                    Data pop=st.pop();
                    boolean isEqual=isEqualData(pop, d);
                    if(isEqual)
                        break;
                    
                    Data max=getMax(pop, d);

                    if(max.dir=='L'){
                        max.hel=max.hel-1;
                        d=max;
                        if(st.isEmpty()){
                            sortList.add(max);
                            
                        }
                        continue;
                    }

                    max.hel-=1;

                    d.dir='G';

                    st.push(max);

                }
            }
        }
        // System.out.println(st);
        while(!st.isEmpty()){
            sortList.add(st.pop());
        }
        Collections.sort(sortList, (i, j)->i.index-j.index);
        List<Integer>ans=new ArrayList<>();
        for(Data d:sortList){
            ans.add(d.hel);
        }
        return ans;
    }
    public boolean isEqualData(Data pop, Data d){
        return pop.hel==d.hel;
    }
    public Data getMax(Data pop, Data d){
        return pop.hel>d.hel?pop:d;
    }
}