package com.naeggeodo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.naeggeodo.entity.chat.Category;
import com.naeggeodo.entity.chat.ChatMain;

public interface ChatMainRepository extends JpaRepository<ChatMain, Long>{
	public List<ChatMain> findByCategoryAndBuildingCode(Category category,String buildingCode);
	public List<ChatMain> findByBuildingCode(String buildingCode);
	
	@Query("SELECT cm FROM ChatMain cm join ChatUser cu on cm.id = cu.chatMain.id WHERE cu.user.id = :user_id")
	public List<ChatMain> findByUserIdInChatUser(String user_id);
	
	@Query("SELECT c FROM ChatMain c WHERE c.id = :id")
	@EntityGraph(attributePaths = {"chatUser"})
	ChatMain findChatMainEntityGraph(@Param("id") Long id);
	
}
