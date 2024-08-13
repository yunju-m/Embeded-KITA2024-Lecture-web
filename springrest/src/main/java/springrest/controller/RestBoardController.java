package springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springrest.domain.RestBoard;
import springrest.service.RestBoardService;

@RestController
public class RestBoardController {

	@Autowired
	private RestBoardService restBoardService;
	
	// GET /board 요청하면 RestBoard에 담고 있는 List와 전송헤더데이터를 JSON으로 변환해서 리턴
	@GetMapping(value="/board")
	public ResponseEntity<List<RestBoard>> listRestBoard() throws Exception {
		List<RestBoard> restBoardList = restBoardService.listRestBoard();
		return ResponseEntity.ok(restBoardList); // statusCode 200 (정상응답)
	}
	
	// GET /board/1 요청하면 RestBoard와 전송헤더데이터를 JSON으로 변환해서 리턴
	// 요청 URI에 {}안에 변수명, @PathVariable과 매핑
	@GetMapping(value="/board/{rbid}")
	public ResponseEntity<RestBoard> getRestBoard(@PathVariable int rbid) throws Exception {
		RestBoard restBoard = restBoardService.getRestBoard(rbid);
		return ResponseEntity.ok(restBoard);
	}
	
	// POST /board 요청하면
	// producer-consumer 패턴
	@PostMapping(value="/board", produces = MediaType.APPLICATION_JSON_VALUE)
	public int insertRestBoard(@RequestBody RestBoard restBoard) throws Exception {
		return restBoardService.insertRestBoard(restBoard);
	}
	
	@PutMapping(value="/board", produces = MediaType.APPLICATION_JSON_VALUE)
	public int updateRestBoared(@RequestBody RestBoard restBoard) throws Exception {
		return restBoardService.updateRestBoard(restBoard);
	}
	
	@DeleteMapping(value="/board/{rbid}")
	public int deleteRestBoard(@PathVariable int rbid) throws Exception {
		return restBoardService.deleteRestBoard(rbid);
	}
	
}
