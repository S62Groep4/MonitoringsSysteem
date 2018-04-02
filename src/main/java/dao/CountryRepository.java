package dao;

import domain.Country;
import domain.SystemModule;

import java.util.List;

/**
 * Created by Sjoerd on 26-2-2018.
 */
public interface CountryRepository {
    Country getCountry(int id);

    List<Country> getCountries();

    Country createCountry(Country country);

    Country updateCountry(Country country);
}
