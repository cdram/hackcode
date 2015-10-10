/***
	Implement an iterator to flatten a 2d vector.

	For example,
	Given 2d vector =

	[
	  [1,2],
	  [3],
	  [4,5,6]
	]
	By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
***/


public class Vector2D {
    
    Queue<Integer> queue = null;

    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<>();
        for(int i =0 ;i< vec2d.size();i++){
            List<Integer> list = vec2d.get(i);
            for(Integer num : list){
                queue.add(num);
            }
        }
    }

    public int next() {
        return queue.poll();   
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */