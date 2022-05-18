package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Offer;
import org.loose.fis.sre.model.User;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class OfferService {
    private static ObjectRepository<Offer> offerRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("offer.db").toFile())
                .openOrCreate("username", "password");

        offerRepository = database.getRepository(Offer.class);
    }
    public static void addOffer(Offer offer)  {
        offerRepository.insert(offer);
    }

}
