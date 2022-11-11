package com.eray.foodlite.Repository;

import com.eray.foodlite.Models.Profile;

public class ProfileRepository {
    public static ProfileRepository Instance;
    private Profile profile;

    public Profile getCurrentUser() {
        return this.profile;
    }

    public void setCurrentUser(Profile profile) {
        this.profile = profile;
    }

    public ProfileRepository() {
        if(Instance == null) {
            Instance = this;
        }
    }
}
