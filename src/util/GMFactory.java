package util;


import model.GeneralModel;
import moz.model.AuctionView;

public class GMFactory {

    public static GeneralModel getGM(AuctionView auction) {
        GeneralModel generalModel = new GeneralModel();
        generalModel.setBody(auction.getDescription());
        generalModel.setTitle(auction.getClient());
        generalModel.setId(auction.getId());
        generalModel.setHeaderL(auction.getProvinceId().toString()); // HEADER_L = 3
        generalModel.setHeaderR(auction.getCityId().toString()); // HEADER_R = 2
        generalModel.setFooterR(auction.getCityId().toString());
        return generalModel;
    }

}
