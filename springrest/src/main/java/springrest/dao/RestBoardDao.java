package springrest.dao;

import java.util.List;

import springrest.domain.RestBoard;

public interface RestBoardDao {

	public abstract List<RestBoard> listRestBoard() throws Exception;

	public abstract RestBoard getRestBoard(int rbid) throws Exception;

	public abstract int insertRestBoard(RestBoard restBoard) throws Exception;

	public abstract int updateRestBoard(RestBoard restBoard) throws Exception;

	public abstract int deleteRestBoard(int rbid) throws Exception;

}
