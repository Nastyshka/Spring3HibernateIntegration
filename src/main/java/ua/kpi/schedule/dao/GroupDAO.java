package ua.kpi.schedule.dao;

import ua.kpi.schedule.model.Group;

/**
 * Created with IntelliJ IDEA.
 * User: Me
 * Date: 28.11.13
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
public class GroupDAO extends GenericDAO<Group> {
    GroupDAO(){
        super(Group.class);
    }
}
