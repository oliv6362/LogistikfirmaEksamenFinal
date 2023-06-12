package dbcontroller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//mockito er framework der 'udgiver' sig for at være den 'rigtige' DBcontroller for at køre dens metoder og få kontakt med mySQL

public class DBControllerTest {
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(connection.prepareStatement("SELECT * FROM user WHERE licenceNr = 1")).thenReturn(preparedStatement);
    }

    @Test
    public void testSelect() throws SQLException {
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true, false); // simulate one row in result set
        when(resultSet.getInt("licenceNr")).thenReturn(1); // simulate licenceNr value in result set

        preparedStatement.setInt(1, 1);
        ResultSet result = preparedStatement.executeQuery();

        if (result.next()) {
            int licenceNr = result.getInt("licenceNr"); // test success: User tabel har kolonne med licenceNr 1
            assertEquals(1, licenceNr);
        }
        Mockito.verify(preparedStatement).executeQuery();
    }
}