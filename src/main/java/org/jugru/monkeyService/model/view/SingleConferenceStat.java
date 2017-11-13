
package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.List;


public class SingleConferenceStat {
    private List<SpeakersRatingPair> pairs = new ArrayList<>();
    private List<Keynote> keynotes = new ArrayList<>();

    public List<SpeakersRatingPair> getPairs() {
        return pairs;
    }

    public void setPairs(List<SpeakersRatingPair> pairs) {
        this.pairs = pairs;
    }

    public List<Keynote> getKeynotes() {
        return keynotes;
    }

    public void setKeynotes(List<Keynote> keynotes) {
        this.keynotes = keynotes;
    }
    
    
    
}
