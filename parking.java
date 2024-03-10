import java.util.HashMap;

class parking {
    int check = -1, check2 = -1;
    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, Integer> map1 = new HashMap<>();

    public void identify(String vec, String RC, int bikeslot[], int carslot[]) {
        if (vec.equals("BIKE")) {
            giveSlotB(RC, bikeslot);
        }
        else if (vec.equals("CAR")) {
            giveSlotC(RC, carslot);
        }
        else {
            System.out.println("Slot not available for this type");
        }
    }

    public void giveSlotB(String RC, int bikeslot[]) {
        if(map.size() < bikeslot.length) {
            int slotno = findAvailableSlotsB(bikeslot);
            map.put(RC, slotno);
            System.out.println("Your Bike with RC no" + " " + RC + " " + "is Parked at slot" + " " + slotno);
        } else {
            System.out.println("Slots Are Full");
        }
    }

    public void giveSlotC(String RC, int carslot[]) {
        if (map1.size() < carslot.length) {
            int slotno1 = findAvailableSlotsC(carslot);
            map1.put(RC, slotno1);
            System.out.println("The car with RC no:" + " " + RC + " " + "is parked at slot" + " " + slotno1);
        } else {
            System.out.println("Slots are full");
        }
    }

    public void unpark(String RC, int bikeslot[], int carslot[]) {
        if (map.containsKey(RC)) {
            int slot = map.get(RC);
            System.out.println("Your Bike is unparked which was at slot " + slot);
            map.remove(RC);
            bikeslot[slot] = 0; // Reset the slot
        } else if (map1.containsKey(RC)) {
            int slot1 = map1.get(RC);
            System.out.println("Your Car is unparked which was at slot " + slot1);
            map1.remove(RC);
            carslot[slot1] = 0; // Reset the slot
        } else {
            System.out.println("No Such Vehicle is parked here");
        }
    }

    public int findAvailableSlotsB(int bikeslot[]) {
        for (int i = 0; i < bikeslot.length; i++) {
            if (bikeslot[i] == 0) {
                bikeslot[i] = 1; // Mark the slot as occupied
                return i;
            }
        }
        return -1; // No available slot
    }

    public int findAvailableSlotsC(int carslot[]) {
        for (int i = 0; i < carslot.length; i++) {
            if (carslot[i] == 0) {
                carslot[i] = 1; // Mark the slot as occupied
                return i;
            }
        }
        return -1; // No available slot
    }
}
