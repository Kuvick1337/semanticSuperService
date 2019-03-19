package com.semantic.service;

import com.semantic.ServiceUtil;
import com.semantic.model.Termin;
import com.semantic.repository.TerminRepository;

import java.sql.Timestamp;

/**
 * Service für die Verwaltung aller Funktionen rund um Termine (Laden, Erstellen, etc)
 */
public class TerminService {

    /**
     * prüft, ob ein Saal zwischen den übergebenen Uhrzeiten frei ist, oder nicht.
     *
     * @param saalId
     * @param date_From
     * @param date_To
     * @return Saal frei? Ja/Nein
     */
    public static boolean isSaalAvailable(int saalId, String date_From, String date_To) {
        Timestamp timeStampFrom = ServiceUtil.convertStringToTimestamp(date_From);
        Timestamp timestampTo = ServiceUtil.convertStringToTimestamp(date_To);

        if (TerminRepository.getTermineForSaalBetween(saalId, timeStampFrom, timestampTo) > 0) {
            return false;
        }

        return true;
    }

    public static boolean addTermin(int saalId, String eventName, String dateFrom, String dateTo, Integer noOfParticipants, boolean needFood) {
        Timestamp timeStampFrom = ServiceUtil.convertStringToTimestamp(dateFrom);
        Timestamp timestampTo = ServiceUtil.convertStringToTimestamp(dateTo);

        Termin termin = new Termin(null, saalId, eventName, timeStampFrom,timestampTo, noOfParticipants, needFood);

        return TerminRepository.addTermin(termin) == 1;
    }

    public static boolean deleteTermin(Integer saalId, String eventName, String dateFrom) {
        Timestamp timeStampFrom = ServiceUtil.convertStringToTimestamp(dateFrom);

        return TerminRepository.delete(saalId,eventName, timeStampFrom) == 1;
    }
}
