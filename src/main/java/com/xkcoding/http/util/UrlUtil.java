/*
 * Copyright (c) 2019-2029, xkcoding & Yangkai.Shen & 沈扬凯 (237497819@qq.com & xkcoding.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xkcoding.http.util;

import lombok.experimental.UtilityClass;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * Url 工具类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/12/24 22:27
 */
@UtilityClass
public class UrlUtil {
	private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;

	/**
	 * 编码
	 *
	 * @param value str
	 * @return encode str
	 */
	public String urlEncode(String value) {
		if (value == null) {
			return "";
		}
		try {
			String encoded = URLEncoder.encode(value, DEFAULT_ENCODING.displayName());
			return encoded.replace("+", "%20").replace("*", "%2A").replace("~", "%7E").replace("/", "%2F");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Failed To Encode Uri", e);
		}
	}
}
