package ilv.dao;

import ilv.model.IlvUser;

import java.io.Serializable;

public interface UserDaoI {
    public Serializable save(IlvUser user);
}