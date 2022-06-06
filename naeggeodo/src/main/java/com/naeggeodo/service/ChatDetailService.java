package com.naeggeodo.service;

import java.util.List;

import com.naeggeodo.dto.TargetMessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naeggeodo.dto.MessageDTO;
import com.naeggeodo.entity.chat.ChatDetail;
import com.naeggeodo.entity.chat.ChatMain;
import com.naeggeodo.entity.user.Users;
import com.naeggeodo.repository.ChatDetailRepository;
import com.naeggeodo.repository.ChatMainRepository;
import com.naeggeodo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ChatDetailService {
	private final ChatDetailRepository chatDetailRepository;
	private final UserRepository userRepository;
	private final ChatMainRepository chatMainRepository;
	
	//dto 로 저장
	@Transactional
	public void save(MessageDTO messageDTO) {
		System.out.println("========chatDetail save()==========");
		Users user = userRepository.getById(messageDTO.getSender());
		ChatMain chatmain = chatMainRepository.getById(messageDTO.chatMain_idToLong());
		
		ChatDetail chatDetail = ChatDetail.create(messageDTO.getContents(), user, chatmain, messageDTO.getType());
		chatDetailRepository.save(chatDetail);
		System.out.println("========chatDetail save()==========");
	}
	@Transactional
	public void save(TargetMessageDTO messageDTO) {
		System.out.println("========chatDetail save()==========");
		Users user = userRepository.getById(messageDTO.getSender());
		ChatMain chatmain = chatMainRepository.getById(messageDTO.chatMain_idToLong());

		ChatDetail chatDetail = ChatDetail.create(messageDTO.getContents(), user, chatmain, messageDTO.getType());
		chatDetailRepository.save(chatDetail);
		System.out.println("========chatDetail save()==========");
	}

	//기존 채팅 내역 불러오기
	@Transactional
	public List<ChatDetail> load(String chatMain_idstr, String user_id){
		Long chatMain_id = Long.parseLong(chatMain_idstr);
		
		return chatDetailRepository.load(chatMain_id, user_id);
	}
//	//기존 채팅 내역 불러오기
//	@Transactional
//	public List<JSONObject> load(String chatMain_idstr, String user_id) throws Exception{
//		Long chatMain_id = Long.parseLong(chatMain_idstr);
//		
//		List<ChatDetail> list_chatDetail = chatDetailRepository.load(chatMain_id, user_id);
//		List<JSONObject> list_json = new ArrayList<>();
//		JSONObject json = new JSONObject();
//		
//		for (int i = 0; i < list_chatDetail.size(); i++) {
//			json = list_chatDetail.get(i).toJSON();
//			json.put("idx", i);
//			list_json.add(json);
//		}
//		return list_json;
//	}
}