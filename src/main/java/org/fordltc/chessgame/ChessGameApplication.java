package org.fordltc.chessgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@SpringBootApplication
@RestController
public class ChessGameApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChessGameApplication.class, args);
    }

    @GetMapping("/getBoard")
    public String hello() {
        ChessBoard chessBoard = ChessBoard.getInstance();
        return Arrays.deepToString(chessBoard.board);
    }
}
