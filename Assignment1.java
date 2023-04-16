
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queues {
	public static int findCurrentIndexInNewQueue(char[] oldQueue, int currentIndex, char[] newQueue) {
		// Find the current index member in the old queue
		char currentMember = oldQueue[currentIndex];
		// Remove all inactive members from the old queue
		List<Character> oldList = new ArrayList<>();
		for (char c : oldQueue) {
			if (c != currentMember && !oldList.contains(c)) {
				oldList.add(c);
			}
		}
		// Create a map to keep track of the indices of each member in the old queue
		Map<Character, List<Integer>> oldIndices = new HashMap<>();
		for (int i = 0; i < oldList.size(); i++) {
			char c = oldList.get(i);
			if (!oldIndices.containsKey(c)) {
				oldIndices.put(c, new ArrayList<>());
			}
			oldIndices.get(c).add(i);
		}
		// Find the index of the current member in the new queue
		List<Integer> indices = oldIndices.getOrDefault(currentMember, new ArrayList<>());
		for (int i = 0; i < newQueue.length; i++) {
			char c = newQueue[i];
			if (c == currentMember) {
				if (indices.contains(i % oldList.size())) {
					return i;
				}
			} else {
				if (oldIndices.containsKey(c)) {
					List<Integer> cIndices = oldIndices.get(c);
					int j = cIndices.indexOf(i % oldList.size());
					if (j >= 0) {
						return (i - j + oldList.size()) % newQueue.length;
					}
				}
			}
		}
		return -1; // Current index member not found in new queue
	}

	public static void main(String[] args) {
		char[] oldQueue = {'A', 'B', 'C', 'D', 'E', 'F', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'A', 'B', 'A'};
		int currentIndex = 7;
		char[] newQueue = {'A', 'B', 'C', 'D', 'E', 'F', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'A', 'B', 'A'};

		int newIndex = findCurrentIndexInNewQueue(oldQueue, currentIndex, newQueue);
		System.out.println("Current Index Member in New Queue: " + newIndex);
	}

}

/*The function takes in the old task queue, the current index in the old queue, and the new task queue, and returns the index of the current index member in the new queue.

The approach is to first remove all inactive members from the old queue and create a map of the indices of each member in the old queue. Then, for each member in 
the new queue, we check if it is the current index member. If it is, we find its index in the old queue and check if it is still active 
in the new queue. If it is, we return its index in the new queue. If it is not, we need to find the index of the next available member to the current index member.*/
