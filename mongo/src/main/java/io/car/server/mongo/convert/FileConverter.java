/**
 * Copyright (C) 2013  Christian Autermann, Jan Alexander Wirwahn,
 *                     Arne De Wall, Dustin Demuth, Saqib Rasheed
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.car.server.mongo.convert;

import java.io.File;

import com.github.jmkgreen.morphia.converters.SimpleValueConverter;
import com.github.jmkgreen.morphia.converters.TypeConverter;
import com.github.jmkgreen.morphia.mapping.MappedField;
import com.github.jmkgreen.morphia.mapping.MappingException;

public class FileConverter extends TypeConverter implements SimpleValueConverter {
	public FileConverter() {
		super(File.class);
	}

	@Override
	public Object encode(Object value, MappedField optionalExtraInfo) {
        return value == null ? null : ((File) value).getAbsolutePath();
	}

    @Override
    @SuppressWarnings("rawtypes")
    public Object decode(Class c, Object o, MappedField i) throws MappingException {
		if (o == null) {
			return null;
		} else if (o instanceof File) {
			return o;
		} else {
			return new File((String) o);
		}
	}

}
