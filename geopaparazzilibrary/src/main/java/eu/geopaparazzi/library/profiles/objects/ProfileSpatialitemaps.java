/*
 * Geopaparazzi - Digital field mapping on Android based devices
 * Copyright (C) 2016  HydroloGIS (www.hydrologis.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.geopaparazzi.library.profiles.objects;

import android.os.Parcel;

/**
 * Created by hydrologis on 19/03/18.
 */
public class ProfileSpatialitemaps extends ARelativePathResource {
    public String url = "";
    public String uploadUrl = "";
    public String modifiedDate = "";
    public String[] visibleLayerNames = null;
    public long size = -1;

    public ProfileSpatialitemaps(){
    }

    protected ProfileSpatialitemaps(Parcel in) {
        relativePath = in.readString();
        url = in.readString();
        uploadUrl = in.readString();
        modifiedDate = in.readString();
        visibleLayerNames = in.createStringArray();
        size = in.readLong();
    }

    public static final Creator<ProfileSpatialitemaps> CREATOR = new Creator<ProfileSpatialitemaps>() {
        @Override
        public ProfileSpatialitemaps createFromParcel(Parcel in) {
            return new ProfileSpatialitemaps(in);
        }

        @Override
        public ProfileSpatialitemaps[] newArray(int size) {
            return new ProfileSpatialitemaps[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(relativePath);
        dest.writeString(url);
        dest.writeString(uploadUrl);
        dest.writeString(modifiedDate);
        dest.writeStringArray(visibleLayerNames);
        dest.writeLong(size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileSpatialitemaps that = (ProfileSpatialitemaps) o;

        if (!relativePath.equals(that.relativePath)) return false;
        return modifiedDate != null ? modifiedDate.equals(that.modifiedDate) : that.modifiedDate == null;
    }

    @Override
    public int hashCode() {
        int result = relativePath.hashCode();
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}