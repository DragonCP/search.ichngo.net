package me.ghsong.board.dto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository

public class Dao {
    final JdbcTemplate jt;

    public Dao(JdbcTemplate jt) {
        this.jt = jt;
    }

    public List<Map<String, ?>> selectAll() {

        return jt.query("select * from word", (rs, rowNum) -> {
            Map<String, Object> mss = new HashMap<>();
            mss.put("id", rs.getString(1));
            mss.put("count", rs.getString(2));
            mss.put("time", rs.getString(3));
            return mss;
        });
    }

}
