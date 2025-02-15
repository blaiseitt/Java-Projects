import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visitedRooms = new boolean[rooms.size()];

        visitRoom(0, rooms, visitedRooms);

        for (boolean room : visitedRooms) {
            if (!room)
                return false;
        }
        return true;
    }

    private void visitRoom(int room, List<List<Integer>> rooms, boolean[] visitedRooms) {
        visitedRooms[room] = true;
        for (int key : rooms.get(room)) {
            if (visitedRooms[key] != true) {
                visitRoom(key, rooms, visitedRooms);
            }
        }
    }
}