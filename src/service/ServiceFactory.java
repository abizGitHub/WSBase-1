package service;

import model.BaseModel;
import model.ModelMap;
import moz.model.*;

import java.util.HashMap;

public class ServiceFactory {

    private HashMap<Class<? extends BaseModel>, ServiceImpl> services;

    private static ServiceFactory o = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return o;
    }

    private ServiceFactory() {
        services = new HashMap<Class<? extends BaseModel>, ServiceImpl>();
        ServiceImpl<Auction, AuctionView> auctionService = new ServiceImpl<Auction, AuctionView>(Auction.class, AuctionView.class);
        ServiceImpl<City, CityView> cityService = new ServiceImpl<City, CityView>(City.class, CityView.class);
        ServiceImpl<Province, Province> provinceService = new ServiceImpl<Province, Province>(Province.class, Province.class);
        ServiceImpl<BusinessT, BusinessT> businessTService = new ServiceImpl<BusinessT, BusinessT>(BusinessT.class, BusinessT.class);
        ServiceImpl<Client, ClientView> clientService = new ServiceImpl<Client, ClientView>(Client.class, ClientView.class);
        ServiceImpl<ModelMap, ModelMap> modelMapService = new ServiceImpl<ModelMap, ModelMap>(ModelMap.class, ModelMap.class);
        services.put(Auction.class, auctionService);
        services.put(City.class, cityService);
        services.put(Province.class, provinceService);
        services.put(BusinessT.class, businessTService);
        services.put(Client.class, clientService);
        services.put(ModelMap.class, modelMapService);
    }

    public HashMap<Class<? extends BaseModel>, ServiceImpl> o() {
        return services;
    }

}
