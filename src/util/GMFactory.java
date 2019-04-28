package util;


import model.GeneralModel;
import moz.model.AuctionView;

public class GMFactory {

    public static GeneralModel getGM(AuctionView auction){
        GeneralModel generalModel = new GeneralModel();
        generalModel.setBody(auction.getDescription());
        generalModel.setTitle(auction.getClient());
        generalModel.setId(auction.getId());
        generalModel.setFooterL("fffooottteeerrr");
        return generalModel;
    }

}
