/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.bridge.context.map.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;


/**
 * @author  Neil Griffin
 */
public class RequestCookieMap implements Map<String, Object> {

	private Cookie[] cookies;

	public RequestCookieMap(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

	public boolean containsKey(Object key) {
		boolean found = false;

		if (key != null) {
			String keyAsString = key.toString();

			if (cookies != null) {

				for (Cookie cookie : cookies) {
					found = cookie.getName().equals(keyAsString);

					if (found) {
						break;
					}
				}
			}
		}

		return found;
	}

	public boolean containsValue(Object value) {
		boolean found = false;

		if (cookies != null) {

			for (Cookie cookie : cookies) {
				found = (cookie == value);

				if (found) {
					break;
				}
			}
		}

		return found;
	}

	public Set<Map.Entry<String, Object>> entrySet() {
		Set<Map.Entry<String, Object>> entrySet = null;

		if (cookies != null) {
			entrySet = new HashSet<Map.Entry<String, Object>>();

			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				RequestCookieMapEntry requestCookieMapEntry = new RequestCookieMapEntry(cookieName, cookie);
				entrySet.add(requestCookieMapEntry);
			}
		}

		return entrySet;
	}

	public Cookie get(Object key) {
		Cookie value = null;

		if ((key != null) && (cookies != null)) {
			String keyAsString = key.toString();

			for (Cookie cookie : cookies) {

				if (cookie.getName().equals(keyAsString)) {
					value = cookie;

					break;
				}
			}
		}

		return value;
	}

	public boolean isEmpty() {
		return ((cookies == null) || (cookies.length == 0));
	}

	public Set<String> keySet() {
		Set<String> keySet = null;

		if (cookies != null) {
			keySet = new HashSet<String>();

			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				keySet.add(cookieName);
			}
		}

		return keySet;
	}

	public Cookie put(String key, Object value) {
		throw new UnsupportedOperationException();
	}

	public void putAll(Map<? extends String, ? extends Object> t) {
		throw new UnsupportedOperationException();
	}

	public Cookie remove(Object key) {
		throw new UnsupportedOperationException();
	}

	public int size() {
		int size = 0;

		if (cookies != null) {
			size = cookies.length;
		}

		return size;
	}

	public Collection<Object> values() {
		Collection<Object> values = null;

		if (cookies != null) {
			values = new HashSet<Object>();

			for (Cookie cookie : cookies) {
				values.add(cookie);
			}
		}

		return values;
	}
}
