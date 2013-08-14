package br.com.supportcomm.freecall.impl.spot;

import java.util.List;



import br.com.supportcomm.freecall.entity.Spot;


/**
 * @generated DT_ID=none
 */

public interface SpotBeanLocal
{

   
    /**
     * @generated DT_ID=none
     */
    public Spot persistSpot(Spot spot);
    public Spot findtSpot(Spot spot);
    
    
    /**
     * @generated DT_ID=none
     */
    public Spot mergeSpot(Spot spot);

    /**
     * @generated DT_ID=none
     */
    public void removeSpot(Spot spot);

    /**
     * @generated DT_ID=none
     */
 
    

    /**
     * @generated DT_ID=none
     */
    public List<Spot> getSpotAll();
  
    public List<Spot> getSpotAllActive();
   
}
