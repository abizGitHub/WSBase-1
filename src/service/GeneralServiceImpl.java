package service;

import model.GeneralModel;
import model.ModelMap;
import moz.model.Auction;
import moz.model.AuctionView;
import moz.model.City;
import moz.model.CityView;
import util.GMFactory;

import java.util.ArrayList;

public class GeneralServiceImpl implements GeneralService {

    private static GeneralServiceImpl ourInstance = new GeneralServiceImpl();

    public static GeneralServiceImpl getInstance() {
        return ourInstance;
    }

    private GeneralServiceImpl() {
    }

    @Override
    public ArrayList<GeneralModel> getTestGeneralList() {
        ArrayList<GeneralModel> testGeneralList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            GeneralModel generalModel = new GeneralModel();
            generalModel.fillMock();
            testGeneralList.add(generalModel);
        }
        return testGeneralList;
    }

    @Override
    public ArrayList<GeneralModel> getAllGeneralList(Integer tableIx) {
        ServiceImpl<Auction, AuctionView> service = ServiceFactory.getInstance().o().get(Auction.class);
        ArrayList<AuctionView> auctionViews = service.loadAllView();
        ArrayList<GeneralModel> list = new ArrayList<>();
        for (AuctionView auctionView : auctionViews) {
            GMFactory.getGM(auctionView);
        }
        return list;
    }

    @Override
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
        ArrayList<GeneralModel> list = GeneralServiceImpl.getInstance().getGeneralListAfter(0, (long) 0);
        System.out.println(list.size());
    }

    @Override
    public ArrayList<Long> getLastGeneralIds() {
        ArrayList<Long> list = new ArrayList<>();
        ServiceImpl<Auction, AuctionView> service = ServiceFactory.getInstance().o().get(Auction.class);
        list.add(service.getLastId());
        list.add(service.getLastId());
        return list;
    }

    @Override
    public ArrayList<ModelMap> getModelMapAfter(Long lastModelMapId) {
        ServiceImpl<ModelMap, ModelMap> mmService = ServiceFactory.getInstance().o().get(ModelMap.class);
        return mmService.loadAllAfter(lastModelMapId, " idDelete is null");
    }

    @Override
    public ArrayList<Long> getModelMap2DeleteAfter(Long lastModelMapId) {
        ServiceImpl<ModelMap, ModelMap> mmService = ServiceFactory.getInstance().o().get(ModelMap.class);
        return mmService.loadAllIdAfter("select idDelete from ", lastModelMapId, "idDelete is not null");
    }

}
