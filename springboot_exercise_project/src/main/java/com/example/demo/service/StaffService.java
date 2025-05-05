package com.example.demo.service;

import com.example.demo.model.Staff;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffService {
    private final Map<Integer, Staff> staffMap = new HashMap<>();
    private int currentId = 1;

    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getStaffById(int id) {
        return staffMap.get(id);
    }

    public Staff createStaff(Staff staff) {
        staff.setId(currentId++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    public Staff updateStaff(int id, Staff updatedStaff) {
        updatedStaff.setId(id);
        staffMap.put(id, updatedStaff);
        return updatedStaff;
    }

    public void deleteStaff(int id) {
        staffMap.remove(id);
    }
}
