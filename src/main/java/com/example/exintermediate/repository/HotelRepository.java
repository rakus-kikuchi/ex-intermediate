package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Hotel;

@Repository
public class HotelRepository {

    @Autowired
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setHotelName(rs.getString("hotel_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));
        return hotel;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Hotel> hotelList(Integer price) {
        if (price == null || price <= 0) {
            String sql = "SELECT * FROM hotels ;";
            List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
            return hotelList;

        } else {
            String sql = "SELECT * FROM hotels WHERE price <= :price ;";
            SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
            List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
            return hotelList;

        }
    }

}
