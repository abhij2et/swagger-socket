/**
 *  Copyright 2012 Wordnik, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.wordnik.api.client.api

import com.wordnik.api.client.model._

import org.codehaus.jackson.map.DeserializationConfig.Feature
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.`type`.TypeReference
import com.wordnik.swagger.runtime.annotations._
import com.wordnik.swagger.runtime.common._
import com.wordnik.swagger.runtime.exception._

import java.io.IOException

import scala.collection.mutable._
import scala.collection.JavaConversions._


/**
 *
 * NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
 * @author tony
 *
 */
object WordListAPI {

    /**
     * Deletes an existing WordList
     *
     * 
     * 
     * @param wordListId  ID of WordList to delete
 @param auth_token  The auth token of the logged-in user, obtained by calling /account.{format}/authenticate/{username} (described above)
 
     * @return  {@link } 
     * @throws APIException 400 - Invalid ID supplied 403 - Not Authorized to delete WordList 404 - WordList not found 
     */
     @MethodArgumentNames(value="wordListId, auth_token") 
     @throws(classOf[APIException])
     def deleteWordList(wordListId:String, auth_token:String)  = {

        //parse inputs
        var resourcePath = "/wordList.{format}/{wordListId}".replace("{format}","json")
        val method = "DELETE";
        var queryParams = new HashMap[String, String]
        var headerParams = new HashMap[String, String]

        if(null != auth_token) {
             headerParams += "auth_token" -> APIInvoker.toPathValue(auth_token)
        }

        if(null != wordListId) {
            resourcePath = resourcePath.replace("{wordListId}", APIInvoker.toPathValue(wordListId))
        }
        
    
        //make the API Call
        APIInvoker.getApiInvoker.invokeAPI(resourcePath, method, queryParams, null, headerParams)
        
                
     }
    /**
     * Fetches a WordList by ID
     *
     * 
     * 
     * @param wordListId  ID of WordList to fetch
 @param auth_token  The auth token of the logged-in user, obtained by calling /account.{format}/authenticate/{username} (described above)
 
     * @return WordList {@link WordList} 
     * @throws APIException 400 - Invalid ID supplied 403 - Not Authorized to access WordList 404 - WordList not found 
     */
     @MethodArgumentNames(value="wordListId, auth_token") 
     @throws(classOf[APIException])
     def getWordListById(wordListId:String, auth_token:String) :WordList = {

        //parse inputs
        var resourcePath = "/wordList.{format}/{wordListId}".replace("{format}","json")
        val method = "GET";
        var queryParams = new HashMap[String, String]
        var headerParams = new HashMap[String, String]

        if(null != auth_token) {
             headerParams += "auth_token" -> APIInvoker.toPathValue(auth_token)
        }

        if(null != wordListId) {
            resourcePath = resourcePath.replace("{wordListId}", APIInvoker.toPathValue(wordListId))
        }
        
    
        //make the API Call
        val response = APIInvoker.getApiInvoker.invokeAPI(resourcePath, method, queryParams, null, headerParams)
        if(null == response || response.length() == 0){
            null
        }        //create output objects if the response has more than one object
        val responseObject = APIInvoker.deserialize(response, classOf[WordList]).asInstanceOf[WordList]
        responseObject        
                
     }
    /**
     * Fetches words in a WordList
     *
     * 
     * 
     * @param wordListId  ID of WordList to use
 @param sortBy  Field to sort by
     *      Allowed values are - createDate,alpha  @param sortOrder  Direction to sort
     *      Allowed values are - asc,desc  @param skip  Results to skip
 @param limit  Maximum number of results to return
 @param auth_token  The auth token of the logged-in user, obtained by calling /account.{format}/authenticate/{username} (described above)
 
     * @return List[WordListWord] {@link WordListWord} 
     * @throws APIException 400 - Invalid ID supplied 403 - Not Authorized to access WordList 404 - WordList not found 
     */
     @MethodArgumentNames(value="wordListId, sortBy, sortOrder, skip, limit, auth_token") 
     @throws(classOf[APIException])
     def getWordListWords(wordListId:String, sortBy:String, sortOrder:String, skip:String, limit:String, auth_token:String) :List[WordListWord] = {

        //parse inputs
        var resourcePath = "/wordList.{format}/{wordListId}/words".replace("{format}","json")
        val method = "GET";
        var queryParams = new HashMap[String, String]
        var headerParams = new HashMap[String, String]

        if(null != sortBy) {
             queryParams += "sortBy" -> APIInvoker.toPathValue(sortBy)
        }
        if(null != sortOrder) {
             queryParams += "sortOrder" -> APIInvoker.toPathValue(sortOrder)
        }
        if(null != skip) {
             queryParams += "skip" -> APIInvoker.toPathValue(skip)
        }
        if(null != limit) {
             queryParams += "limit" -> APIInvoker.toPathValue(limit)
        }

        if(null != auth_token) {
             headerParams += "auth_token" -> APIInvoker.toPathValue(auth_token)
        }

        if(null != wordListId) {
            resourcePath = resourcePath.replace("{wordListId}", APIInvoker.toPathValue(wordListId))
        }
        
    
        //make the API Call
        val response = APIInvoker.getApiInvoker.invokeAPI(resourcePath, method, queryParams, null, headerParams)
        if(null == response || response.length() == 0){
            null
        }        
        val typeRef = new TypeReference[Array[WordListWord]] {}
        try {
            val responseObject = APIInvoker.mapper.readValue(response, typeRef).asInstanceOf[Array[WordListWord]]
            responseObject.toList
        } catch { 
        	case ioe:IOException => {
	            val args = Array(response, typeRef.toString())
	            throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, args, "Error in converting response json value to java object : " + ioe.getMessage(), ioe)
	        }
	        case _:Exception => throw new APIException(APIExceptionCodes.ERROR_CONVERTING_JSON_TO_JAVA, "Error in converting response json value to java object")
        }                        
     }

}