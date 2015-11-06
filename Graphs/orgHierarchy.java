import java.io.*;
import java.util.*;

class Hierarchy {
    static Set<Character> visited = null;
	
    public static TreeMap<Character, List<Character>> formAdjacencyMap(String[] arr){
		TreeMap<Character, List<Character>> map = new TreeMap<>();
        for(String i : arr){
            i = i.trim();
            Character c = i.charAt(0);
            Character d = i.charAt(1);
            if(!map.containsKey(c)){
                List<Character> list = new ArrayList<>();
                map.put(c, list);                
            }
            if(!map.containsKey(d)){
                List<Character> list = new ArrayList<>();
                map.put(d, list);                
            }
			map.get(c).add(i.charAt(1));
        }
        return map;
    }
    
    public static String dfs(TreeMap<Character, List<Character>> map, Character c){
        if(!map.containsKey(c)) return "";
        if(map.containsKey(c) && map.get(c).size() == 0) return String.valueOf(c);         
        List<Character> children = map.get(c);
        StringBuilder sb = new StringBuilder();
		sb.append(c);
        sb.append("[");
        for(Character child : children){
            String op = dfs(map, child);
            visited.add(child);
            sb.append(op);
            sb.append(",");
        }
        sb.setLength(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
    
    public static String output(String input, Set<Character> visited){
        String[] arr = input.split("\\|");
        TreeMap<Character, List<Character>> map = formAdjacencyMap(arr);
		System.out.println(map.toString());
        StringBuilder sb = new StringBuilder();
		sb.append("[");
        for(Character c : map.keySet()){
            if(!visited.contains(c)){
                sb.append(dfs(map, c));
                visited.add(c);    
            }
        }
        sb.setLength(sb.length()-1);
		sb.append("]");
        return sb.toString();
    }
    
    
    public static void main (String[] args) throws IOException {
		/*** 
			Sample Input
				ab | ae | bc
				ab | bc | cd | ae | cx | xz
		***/	
		
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
			System.out.println("Input => " + line);
			visited = new HashSet<Character>();
            String op = output(line, visited);
            System.out.println(op);
        }
    }
}
