package service;

import model.*;
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
        ServiceImpl<UserAccount, UserAccount> userAccountService = new ServiceImpl<UserAccount, UserAccount>(UserAccount.class, UserAccount.class);
        ServiceImpl<UserAccountLog, UserAccountLogView> userAccountLogService
                = new ServiceImpl<UserAccountLog, UserAccountLogView>(UserAccountLog.class, UserAccountLogView.class);
        ServiceImpl<TagVisiblity, TagVisiblity> tagVisService = new ServiceImpl<>(TagVisiblity.class, TagVisiblity.class);
        ServiceImpl<Group, Group> groupService = new ServiceImpl<Group, Group>(Group.class, Group.class);
        ServiceImpl<UserToGroup, UserToGroupView> groupUserService = new ServiceImpl<UserToGroup, UserToGroupView>(UserToGroup.class, UserToGroupView.class);
        ServiceImpl<GMStruct, GMStruct> gMStructService = new ServiceImpl<GMStruct, GMStruct>(GMStruct.class, GMStruct.class);


        services.put(Auction.class, auctionService);
        services.put(City.class, cityService);
        services.put(Province.class, provinceService);
        services.put(BusinessT.class, businessTService);
        services.put(Client.class, clientService);
        services.put(ModelMap.class, modelMapService);
        services.put(UserAccount.class, userAccountService);
        services.put(UserAccountLog.class, userAccountLogService);
        services.put(TagVisiblity.class, tagVisService);
        services.put(Group.class, groupService);
        services.put(UserToGroup.class, groupUserService);
        services.put(GMStruct.class, gMStructService);
    }

    public HashMap<Class<? extends BaseModel>, ServiceImpl> o() {
        return services;
    }

}
