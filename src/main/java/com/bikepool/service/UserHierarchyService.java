package com.bikepool.service;

import com.bikepool.dto.OrgUser;

import java.util.List;

/**
 * Created by rampal on 13/11/17.
 */
public interface UserHierarchyService {
    OrgUser addUser(OrgUser user);
    boolean updateManager(Integer userId, Integer managerId);
    List<OrgUser> getUserUnderManager(Integer managerId);
    List<OrgUser> getAllManagersUptoTopLevel(Integer userId);
    List<OrgUser> getUserWithEmailPrefix(String emailPrefix);
}
