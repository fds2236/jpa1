//package com.example.demo.controller;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.VerticalAlignment;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.ApiRequestList;
//import com.example.demo.repository.ApiRequestListRepository;
//import com.example.demo.service.ExcelDownService;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.OutputStream;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/excel")
//public class ExcelDownController {
//	
//	private final ExcelDownService excelDownService;
//	private final ApiRequestListRepository apiRequestListRepository;
//
//    @Autowired
//    public ExcelDownController(ExcelDownService excelDownService, ApiRequestListRepository apiRequestListRepository) {
//        this.excelDownService = excelDownService;
//        this.apiRequestListRepository = apiRequestListRepository;
//    }
//	
////	// 임시 데이터 삽입
////    @GetMapping("/insert-data")
////    public String insertData() {
////        int numberOfInserts = 20000;
////        excelDownService.insertData(numberOfInserts);
////        return "임시데이터 삽입 성공";
////    }
////    
////	// 데이터 조회
////	@GetMapping("/select-data")
////	public List<ApiRequestList> selectData(){
////		return excelDownService.selectData();
////	} 
//	
//	// 엑셀 다운로드1 => XSSF 사용
//	@GetMapping("/downLoad")
//	public void download(HttpServletResponse response,
//			@RequestParam(name = "orgId", required = false) Long orgId,
//            @RequestParam(name = "apiName", required = false) String apiName) throws IOException {
//		
////		    List<ApiRequestList> requestList = excelDownService.selectData(orgId, apiName);
////		    Long requestTotalCount = excelDownService.countData(orgId, apiName);
//		    
//		// 데이터 조회
////		List<ApiRequestList> requestList = excelDownService.selectData();
////		Long requestTotalCount = excelDownService.countData(); // 맨 마지막 줄에 통계 행 추가 셀 병합
//				
//		// 컨텐츠 타입과 파일 이름 설정
//	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//	    response.setHeader("Content-Disposition", "attachment; filename=list.xlsx");
//		
//		// 엑셀 파일 설정
//		XSSFWorkbook workbook = new XSSFWorkbook();
//		Sheet sheet = workbook.createSheet("시트1");
//		XSSFCellStyle columnStyle = workbook.createCellStyle();
//		
//		// 열 제목
//		String[] columnTitles = {"org아이디", "api아이디", "api이름", "callCount", "itemCount", "요청일"};
//		Row columnRow = sheet.createRow(1);
//		for (int i = 0; i < columnTitles.length; i++) {
//			Cell cell = columnRow.createCell(i);
//			cell.setCellValue(columnTitles[i]);
//			columnStyle.setAlignment(HorizontalAlignment.CENTER);
//			columnStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//	        columnStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); 
//	        columnStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//	        cell.setCellStyle(columnStyle);
//	        sheet.setColumnWidth(i, 15 * 256); 
//		}
//		
//				
//	    // 데이터 삽입
//	    int rowIndex = 2;
//	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
//	    for (ApiRequestList apiRequestList : requestList) {
//	        Row dataRow = sheet.createRow(rowIndex++);
//	        dataRow.createCell(0).setCellValue(apiRequestList.getOrgId());
//	        dataRow.createCell(1).setCellValue(apiRequestList.getApiId());
//	        dataRow.createCell(2).setCellValue(apiRequestList.getApiName());
//	        dataRow.createCell(3).setCellValue(apiRequestList.getCallCount());
//	        dataRow.createCell(4).setCellValue(apiRequestList.getItemCount());
//	        LocalDateTime localDateTime = apiRequestList.getRequestTime().toLocalDateTime();
//	        dataRow.createCell(5).setCellValue(localDateTime.format(formatter));
//	    }
//		
//       try (OutputStream outputStream = response.getOutputStream()) {
//           workbook.write(outputStream);
//       } catch (IOException e) {
//           e.printStackTrace();
//       } finally {
//           workbook.close();
//       }
//   }
//		
////	@GetMapping("/downLoad2")
////	public void download2(HttpServletResponse response) throws IOException {
////	    List<ApiRequestList> requestList = excelDownService.selectData();
////	    Long requestTotalCount = excelDownService.countData();
////	    
////	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
////	    response.setHeader("Content-Disposition", "attachment; filename=list2.xlsx");
////
////	    try (SXSSFWorkbook workbook = new SXSSFWorkbook()) {
////	        Sheet sheet = workbook.createSheet("시트1");
////	        CellStyle headerStyle = workbook.createCellStyle();
////	        CellStyle columnStyle = workbook.createCellStyle();
////
////	        String[] columnTitles = {"orgId", "apiId", "apiName", "callCount", "itemCount", "requestTime"};
////	        Row titleRow = sheet.createRow(0);
////	        Cell titleCell = titleRow.createCell(0);
////	        titleCell.setCellValue("업무 통계"); // Set title
////	        headerStyle.setAlignment(HorizontalAlignment.CENTER);
////	        titleCell.setCellStyle(headerStyle); // Apply style
////	        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columnTitles.length - 1)); // Merge cells
////
////	        Row columnRow = sheet.createRow(1);
////	        for (int i = 0; i < columnTitles.length; i++) {
////	            Cell cell = columnRow.createCell(i);
////	            cell.setCellValue(columnTitles[i]);
////	            columnStyle.setAlignment(HorizontalAlignment.CENTER);
////	            columnStyle.setVerticalAlignment(VerticalAlignment.CENTER);
////	            columnStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
////	            columnStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
////	            cell.setCellStyle(columnStyle);
////	            sheet.setColumnWidth(i, 15 * 256);
////	        }
////	        
////	        int rowIndex = 2;
////	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
////	        for (ApiRequestList apiRequestList : requestList) {
////	            Row dataRow = sheet.createRow(rowIndex++);
////	            dataRow.createCell(0).setCellValue(apiRequestList.getOrgId());
////	            dataRow.createCell(1).setCellValue(apiRequestList.getApiId());
////	            dataRow.createCell(2).setCellValue(apiRequestList.getApiName());
////	            dataRow.createCell(3).setCellValue(apiRequestList.getCallCount());
////	            dataRow.createCell(4).setCellValue(apiRequestList.getItemCount());
////	            LocalDateTime localDateTime = apiRequestList.getRequestTime().toLocalDateTime();
////	            dataRow.createCell(5).setCellValue(localDateTime.format(formatter));
////	        }
////	        
////	        // Add a row for the total count
////	        Row totalCountRow = sheet.createRow(rowIndex);
////	        Cell totalCountCell = totalCountRow.createCell(0);
////	        totalCountCell.setCellValue("총 데이터 개수 : " + requestTotalCount);
////	        totalCountCell.setCellStyle(columnStyle); 
////	        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, columnTitles.length - 1));
////
//////	        // Create a cell for the count value
//////	        Cell countValueCell = totalCountRow.createCell(columnTitles.length);
//////	        countValueCell.setCellValue(requestTotalCount);
////
////	        
////	        try (OutputStream outputStream = response.getOutputStream()) {
////	            workbook.write(outputStream);
////	        } catch (IOException e) {
////	            e.printStackTrace();
////	        }
////	    }
////	}
//
//
//		
//		
//		
//
//}
//
//	
