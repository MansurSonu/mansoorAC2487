package com.sisoeducation.generator;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmpIdGenerator implements IdentifierGenerator {

	
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "AC24SISO";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) {
		Long sequenceNumber = getNextSequenceNumber(session);

		return PREFIX + String.format("%03d", sequenceNumber);
	}

	private Long getNextSequenceNumber(SharedSessionContractImplementor session) {
		try {
			return session.doReturningWork(connection -> {
				try (PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO emp_id VALUES (null)", PreparedStatement.RETURN_GENERATED_KEYS)) {
					preparedStatement.executeUpdate();

					try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
						if (resultSet.next()) {
							return resultSet.getLong(1);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				throw new RuntimeException("Unable to retrieve the sequence number");
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error generating Vendor ID", e);
		}
	}

}
