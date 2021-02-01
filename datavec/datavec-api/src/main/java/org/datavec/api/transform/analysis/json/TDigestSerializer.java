/*
 *  ******************************************************************************
 *  *
 *  *
 *  * This program and the accompanying materials are made available under the
 *  * terms of the Apache License, Version 2.0 which is available at
 *  * https://www.apache.org/licenses/LICENSE-2.0.
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  * License for the specific language governing permissions and limitations
 *  * under the License.
 *  *
 *  * SPDX-License-Identifier: Apache-2.0
 *  *****************************************************************************
 */

package org.datavec.api.transform.analysis.json;

import com.tdunning.math.stats.TDigest;
import org.apache.commons.codec.binary.Base64;
import org.nd4j.shade.jackson.core.JsonGenerator;
import org.nd4j.shade.jackson.core.JsonProcessingException;
import org.nd4j.shade.jackson.databind.JsonSerializer;
import org.nd4j.shade.jackson.databind.SerializerProvider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TDigestSerializer extends JsonSerializer<TDigest> {
    @Override
    public void serialize(TDigest td, JsonGenerator j, SerializerProvider sp) throws IOException, JsonProcessingException {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(baos)){
            oos.writeObject(td);
            oos.close();
            byte[] bytes = baos.toByteArray();
            Base64 b = new Base64();
            String str = b.encodeAsString(bytes);
            j.writeStartObject();
            j.writeStringField("digest", str);
            j.writeEndObject();
        }
    }
}
