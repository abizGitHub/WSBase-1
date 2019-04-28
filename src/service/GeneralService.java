package service;

import model.GeneralModel;
import moz.model.Auction;
import moz.model.AuctionView;
import util.GMFactory;

import java.util.ArrayList;

public class GeneralService {

    private static GeneralService ourInstance = new GeneralService();

    public static GeneralService getInstance() {
        return ourInstance;
    }

    private GeneralService() {
    }

    public ArrayList<GeneralModel> getTestGeneralList() {
        ArrayList<GeneralModel> testGeneralList = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            GeneralModel generalModel = new GeneralModel();
            generalModel.fillMock();
            testGeneralList.add(generalModel);
        }
        return testGeneralList;
    }

    public ArrayList<GeneralModel> getAllGeneralList(Integer tableIx) {
        ServiceImpl<Auction, AuctionView> service = ServiceFactory.getInstance().o().get(Auction.class);
        ArrayList<AuctionView> auctionViews = service.loadAllView();
        ArrayList<GeneralModel> list = new ArrayList<>();
        for (AuctionView auctionView : auctionViews) {
            GMFactory.getGM(auctionView);
        }
        return list;
    }

    public ArrayList<GeneralModel> getGeneralListAfter(Integer tableIx, Long id) {
        ServiceImpl<Auction, AuctionView> service = ServiceFactory.getInstance().o().get(Auction.class);
        ArrayList<AuctionView> auctionViews = service.loadAllViewAfter(id);
        ArrayList<GeneralModel> list = new ArrayList<>();
        for (AuctionView auctionView : auctionViews) {
            list.add(GMFactory.getGM(auctionView));
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<GeneralModel> list = GeneralService.getInstance().getGeneralListAfter(0, (long) 0);
        System.out.println(list.size());
    }

    public ArrayList<Long> getLastGeneralIds() {
        ArrayList<Long> list = new ArrayList<>();
        ServiceImpl<Auction, AuctionView> service = ServiceFactory.getInstance().o().get(Auction.class);
        list.add(service.getLastId());
        list.add(service.getLastId());
        return list;
    }
}
