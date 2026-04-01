class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String str : strs){
            if (str == ""){
                str="EMPTY#";
            }
            res += str + "\",\""; 
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<String>();
        for (String st : str.split("\",\"")){
            System.out.println(st);
            if(st.equals("")) continue; 
            if(st.equals( "EMPTY#")){
                st = "";
            }
            res.add(st); 
        }
        return res;
    }
}
