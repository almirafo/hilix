package br.com.hilix.impl.group;

import java.util.List;

import br.com.hilix.entity.Group;



/**
 * @generated DT_ID=none
 */

public interface GroupBeanLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Group persistGroup(Group group);

    /**
     * @generated DT_ID=none
     */
    public Group mergeGroup(Group group);

    /**
     * @generated DT_ID=none
     */
    public void removeGroup(Group group);


    /**
     * @generated DT_ID=none
     */
    public List<Group> getGroupAll();

    /**
     * @generated DT_ID=none
     */
    public List<Group> getGroupById(Long id);



}
