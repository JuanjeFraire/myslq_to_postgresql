package com.ehsaniara.multidatasource.controller;

import com.ehsaniara.multidatasource.handler.ResourceNotFoundException;
import com.ehsaniara.multidatasource.model.*;
import com.ehsaniara.multidatasource.service.HousingService;
import com.ehsaniara.multidatasource.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
@RestController
public class HousingControllerImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(HousingControllerImpl.class);

    private final HousingService housingService;
    private final UserService userService;

    public HousingControllerImpl(HousingService housingService, UserService userService) {
        this.housingService = housingService;
        this.userService = userService;
    }

    @RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
    public Housing getHousing(@PathVariable("id") Long id) {
        LOGGER.info("foo");
        return housingService.getHousing(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Housing"));
    }

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public Housing createHousing(@RequestBody Housing customer) throws CloneNotSupportedException {

        List<Housing> housingList = this.getHousingListToSave();
        int totalHousings = housingList.size();
        for (int i = 0; i < totalHousings; i++) {
            Housing housing = housingList.get(i);
            try {
                housingService.createHousing(housing);
            } catch (Exception e) {
                LOGGER.error("Error saving housing " + (i + 1) + totalHousings + " > " + housing + "\n" + e.getMessage(), e);
            }
        }
        LOGGER.info("Saved " + housingList.size() + " housings");
        List<User> userList = userService.findAll();
        for (User user : userList) {
            User cloned = this.getClonedUser(user);
            userService.createUser(cloned);
        }
        LOGGER.info("Saved " + userList.size() + " users");
        return null;
    }

    private List<Housing> getHousingListToSave() {
        List<Housing> housingList = housingService.findAll();
        List<Housing> housingListToConvert = new ArrayList<>();
        int totalHousings = housingList.size();
        LOGGER.info(totalHousings + " housings found!");
        for (int i = 0; i < totalHousings; i++) {
            Housing housing = housingList.get(i);
            Housing cloned = this.getClonedHousing(housing);
            housingListToConvert.add(cloned);
            LOGGER.info("Converted housing  " + (i + 1) + " / " + totalHousings);
        }
        return housingListToConvert;
    }

    private Housing getClonedHousing(Housing origin) {
        Housing destiny = new Housing();

        destiny.setCreatedBy(origin.getCreatedBy());
        destiny.setCreatedDate(origin.getCreatedDate());
        destiny.setModifiedBy(origin.getModifiedBy());
        destiny.setLastModifiedDate(origin.getLastModifiedDate());
        destiny.setActive(origin.getActive());

        destiny.setTitle(origin.getTitle());
        destiny.setUrl(origin.getUrl());
        destiny.setM2Constructed(origin.getM2Constructed());
        destiny.setM2Usable(origin.getM2Usable());
        destiny.setFloor(origin.getFloor());
        destiny.setRooms(origin.getRooms());
        destiny.setBathrooms(origin.getBathrooms());
        destiny.setGarage(origin.getGarage());
        destiny.setLift(origin.getLift());
        destiny.setAddress(origin.getAddress());
        destiny.setSite(origin.getSite());
        destiny.setCode(origin.getCode());
        destiny.setDescription(origin.getDescription());
        destiny.setLastUpdateWebRaw(origin.getLastUpdateWebRaw());
        destiny.setLastUpdateWeb(origin.getLastUpdateWeb());
        destiny.setLocationRaw(origin.getLocationRaw());
        destiny.setPhotosAmount(origin.getPhotosAmount());
        destiny.setLastTimeFoundInList(origin.getLastTimeFoundInList());
        destiny.setLatitude(origin.getLatitude());
        destiny.setLongitude(origin.getLongitude());
        destiny.setLocationType(origin.getLocationType());
        destiny.setLocationConfirmed(origin.getLocationConfirmed());
        destiny.setTerrace(origin.getTerrace());
        destiny.setRooftop(origin.getRooftop());
        destiny.setFurnished(origin.getFurnished());
        destiny.setOrientation(origin.getOrientation());
        destiny.setCourtyard(origin.getCourtyard());
        destiny.setToReform(origin.getToReform());
        destiny.setStorageRoom(origin.getStorageRoom());
        destiny.setAntiquity(origin.getAntiquity());
        destiny.setIntermediaryPayment(origin.getIntermediaryPayment());
        destiny.setPremises(origin.getPremises());
        destiny.setReliableLocation(origin.getReliableLocation());
        destiny.setCompletelyReviewed(origin.getCompletelyReviewed());
        destiny.setBankable100(origin.getBankable100());
        destiny.setVisitable(origin.getVisitable());
        destiny.setCurrentCost(origin.getCurrentCost());

        destiny.setAdvertiser(origin.getAdvertiser() != null ? this.getClonedAdvertiser(origin.getAdvertiser()) : null);
        destiny.setUserNotesForHousing(origin.getUserNotesForHousing() != null ? this.getCloneUserNotesForHousing(origin.getUserNotesForHousing(), destiny) : null);

        destiny.setPhotosList(this.getClonedPhotosList(origin.getPhotosList(), destiny));
        destiny.setCostList(this.getClonedCostList(origin.getCostList(), destiny));
        destiny.setFeatureList(this.getClonedFeatureList(origin.getFeatureList(), destiny));

        return destiny;
    }

    private UserNotesForHousing getCloneUserNotesForHousing(UserNotesForHousing origin, Housing housing){
        UserNotesForHousing destiny = new UserNotesForHousing();
        destiny.setNote(origin.getNote());
        destiny.setVisited(origin.isVisited());
        destiny.setHousing(housing);
        return destiny;
    }

    private Advertiser getClonedAdvertiser(Advertiser origin) {
        Advertiser destiny = new Advertiser();
        destiny.setPhoneNumber(origin.getPhoneNumber());
        destiny.setPhoneNumber2(origin.getPhoneNumber2());
        destiny.setName(origin.getName());
        destiny.setUrl(origin.getUrl());
        destiny.setAdvertiserType(origin.getAdvertiserType());
        return destiny;
    }

    private List<Photo> getClonedPhotosList(List<Photo> originList, Housing housing) {
        List<Photo> destinyList = new ArrayList<>();
        for (Photo origin : originList) {
            Photo destiny = new Photo();

            destiny.setPhotoUrl(origin.getPhotoUrl());
            destiny.setHousingPhotoUrl(origin.getHousingPhotoUrl());
            destiny.setPhotoPath(origin.getPhotoPath());
            destiny.setPhotoIndex(origin.getPhotoIndex());
            destiny.setHousing(housing);

            destinyList.add(destiny);
        }
        return destinyList;
    }


    private List<Cost> getClonedCostList(List<Cost> originList, Housing housing) {
        List<Cost> destinyList = new ArrayList<>();
        for (Cost origin : originList) {
            Cost destiny = new Cost();
            destiny.setValue(origin.getValue());
            destiny.setHousing(origin.getHousing());
            destiny.setHousing(housing);
            destinyList.add(destiny);
        }
        return destinyList;
    }

    private List<Feature> getClonedFeatureList(List<Feature> originList, Housing housing) {
        List<Feature> destinyList = new ArrayList<>();
        for (Feature origin : originList) {
            Feature destiny = new Feature();
            destiny.setValue(origin.getValue());
            destiny.setHousing(origin.getHousing());
            destiny.setHousing(housing);
            destinyList.add(destiny);
        }
        return destinyList;
    }

    private User getClonedUser(User origin) {
        User destiny = new User();

        destiny.setCreatedBy(origin.getCreatedBy());
        destiny.setCreatedDate(origin.getCreatedDate());

        destiny.setUserName(origin.getUserName());
        destiny.setUserOptions(this.getClonedUserOptions(origin.getUserOptions(), destiny));

        return destiny;
    }

    private UserOptions getClonedUserOptions(UserOptions origin, User user) {
        UserOptions destiny = new UserOptions();

        destiny.setUser(user);
        destiny.setBudget(origin.getBudget());
        destiny.setExcludedHousingIdList(origin.getExcludedHousingIdList());
        destiny.setFavoriteList(origin.getFavoriteList());
        destiny.setMaxCost(origin.getMaxCost());
        destiny.setM2ConstructedMin(origin.getM2ConstructedMin());
        destiny.setM2ConstructedMax(origin.getM2ConstructedMax());
        destiny.setM2ConstructedUnknown(origin.getM2ConstructedUnknown());
        destiny.setFloorMaxWithoutLift(origin.getFloorMaxWithoutLift());
        destiny.setFloorMin(origin.getFloorMin());
        destiny.setFloorUnknown(origin.getFloorUnknown());
        destiny.setLiftUnknown(origin.getLiftUnknown());
        destiny.setRoomsMin(origin.getRoomsMin());
        destiny.setRoomsUnknown(origin.getRoomsUnknown());
        destiny.setMapCenterLatitude(origin.getMapCenterLatitude());
        destiny.setMapCenterLongitude(origin.getMapCenterLongitude());
        destiny.setMapLeftUpperCornerLatitude(origin.getMapLeftUpperCornerLatitude());
        destiny.setMapLeftUpperCornerLongitude(origin.getMapLeftUpperCornerLongitude());
        destiny.setMapRightLowerCornerLatitude(origin.getMapRightLowerCornerLatitude());
        destiny.setMapRightLowerCornerLongitude(origin.getMapRightLowerCornerLongitude());
        destiny.setMapCenterZoom(origin.getMapCenterZoom());

        return destiny;
    }


}
