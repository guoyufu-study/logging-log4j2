/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.core.parser;

import org.apache.logging.log4j.core.LogEvent;

import java.io.IOException;
import java.io.InputStream;

/**
 * Parse the output from a layout into instances of {@link LogEvent}.
 */
public interface LogEventParser {

    /**
     * Parse from an InputStream. The input stream may contain multiple log events.
     * This method will read one log event and leave the stream open and positioned to read the
     * next log event.
     *
     * @param input  the input stream
     *
     * @return the parsed LogEvent, or {@literal null} of end of input is reached.
     * @throws IOException if unable to read from the input
     * @throws ParseException if the input is malformed and cannot be parsed as a LogEvent
     */
    LogEvent parseFrom(InputStream input) throws IOException, ParseException;

    /**
     * Parse from a byte array, which is expected to contain exactly one log event.
     *
     * @param input  the byte array
     *
     * @return the parsed LogEvent, never {@literal null}.
     * @throws ParseException if the input is malformed and cannot be parsed as a LogEvent
     */
    LogEvent parseFrom(byte[] input) throws ParseException;

    /**
     * Parse from a specified range of a byte array. The specified range is expected to contain
     * exactly one log event.
     *
     * @param input  the byte array
     * @param offset  the initial offset
     * @param length  the length
     *
     * @return the parsed LogEvent, never {@literal null}.
     * @throws ParseException if the input is malformed and cannot be parsed as a LogEvent
     */
    LogEvent parseFrom(byte[] input, int offset, int length) throws ParseException;
}