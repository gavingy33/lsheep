package com.lsheep.customer.web.location.dao;

import java.util.List;

import com.lsheep.customer.database.model.SPosition;

public interface PositionDao {

	void saveSPosition(SPosition sPosition);

	void updateSPosition(SPosition sPosition);

	void deleteSPosition(SPosition sPosition);

	SPosition getSPosition(SPosition sPosition);

	List<SPosition> getSPositions(SPosition sPosition);

}
